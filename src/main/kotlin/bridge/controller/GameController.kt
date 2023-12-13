package bridge.controller

import bridge.view.InputView
import bridge.view.OutputView

class GameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun start() {
        outputView.printStartMessage()
        outputView.printInputBridgeSizeMessage()
        val bridgeSize = inputView.readBridgeSize()
    }
}