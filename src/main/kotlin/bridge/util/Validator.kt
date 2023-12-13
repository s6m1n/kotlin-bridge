package bridge.util

import bridge.util.Constant.DOWN
import bridge.util.Constant.INVALID_BRIDGE_MOVING_PLACE
import bridge.util.Constant.INVALID_BRIDGE_RETRY_COMMAND
import bridge.util.Constant.INVALID_BRIDGE_SIZE_FORMAT
import bridge.util.Constant.INVALID_BRIDGE_SIZE_RANGE
import bridge.util.Constant.MAX_BRIDGE_SIZE
import bridge.util.Constant.MIN_BRIDGE_SIZE
import bridge.util.Constant.QUIT
import bridge.util.Constant.RETRY
import bridge.util.Constant.UP

object Validator {
    fun validateBridgeSize(size: String): Int {
        return try {
            require(size.toInt() in (MIN_BRIDGE_SIZE..MAX_BRIDGE_SIZE)) { INVALID_BRIDGE_SIZE_RANGE }
            size.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_BRIDGE_SIZE_FORMAT)
        }
    }

    fun validateMovingPlace(movingPlace: String): String {
        require(movingPlace == UP || movingPlace == DOWN) { INVALID_BRIDGE_MOVING_PLACE }
        return movingPlace
    }

    fun validateRetryCommand(retryCommand: String): String {
        require(retryCommand == QUIT || retryCommand == RETRY) { INVALID_BRIDGE_RETRY_COMMAND }
        return retryCommand
    }

}