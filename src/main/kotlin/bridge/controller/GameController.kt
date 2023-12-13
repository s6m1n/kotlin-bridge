package bridge.controller

import bridge.BridgeRandomNumberGenerator
import bridge.model.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

class GameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    fun start() {
        outputView.printStartMessage()
        outputView.printInputBridgeSizeMessage()
        val bridgeSize = inputView.readBridgeSize()
        val bridge = bridgeMaker.makeBridge(bridgeSize)

        crossBridge(bridge)


        outputView.printChoiceMovingPlace()
        inputView.readMoving()
    }

    private fun crossBridge(bridge: List<String>) {
    }
}