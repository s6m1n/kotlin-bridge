package bridge.controller

import bridge.BridgeRandomNumberGenerator
import bridge.model.BridgeGame
import bridge.model.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

class GameController(
    private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView()
) {

    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())

    fun start() {
        outputView.printStartMessage()
        outputView.printInputBridgeSizeMessage()
        val bridgeSize = inputView.readBridgeSize()
        do {
            val bridgeAnswers = bridgeMaker.makeBridge(bridgeSize)
            play(bridgeAnswers)
        } while (isRestartable())
    }

    private fun play(bridgeAnswers: List<String>) {
        val moveHistory = listOf<MutableList<String>>(mutableListOf(), mutableListOf()) // 빈 다리 문자열 생성
        for (answer in bridgeAnswers) { // 다리 사이즈만큼 턴 반복
            outputView.printChoiceMovingPlace() // 이동 칸 안내 메시지 출력
            val input = inputView.readMoving() // 이동 칸 입력 받기
            val result = BridgeGame().move(moveHistory, answer, input) // 입력과 정답을 바탕으로 이동 진행
            outputView.printMap(result)
        }
    }

    private fun isRestartable() = false
}