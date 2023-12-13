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
        val bridgeString = listOf<MutableList<String>>(mutableListOf(), mutableListOf()) // 빈 다리 문자열 생성
        for (answer in bridgeAnswers) { // 다리 사이즈만큼 턴 반복
            outputView.printChoiceMovingPlace() // 이동 칸 안내 문자
            val input = inputView.readMoving() // 이동 칸 입력 받기
            val (upperResult, lowerResult) = BridgeGame().move(answer, input) // 입력값 바탕으로 결과 받아오기
            bridgeString.add(upperResult, lowerResult) // 다리 문자열에 추가
            makeTurnResult(bridgeString) // 다리 문자열 기반으로 결과 생성
        }
    }

    private fun makeTurnResult(bridgeString: List<MutableList<String>>) {
        val bridgeResultString = bridgeString.map { it.joinToString(separator = " | ", prefix = "[ ", postfix = " ]") }
        bridgeResultString.forEach { bridge ->
            bridge.forEach { print(it) }
            println()
        }
    }

    private fun List<MutableList<String>>.add(s1: String, s2: String) {
        this[0].add(s1)
        this[1].add(s2)
    }

    private fun isRestartable() = false
}