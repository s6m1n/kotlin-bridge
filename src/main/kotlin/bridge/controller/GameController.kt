package bridge.controller

import bridge.BridgeRandomNumberGenerator
import bridge.model.BridgeGame
import bridge.model.BridgeMaker
import bridge.util.Constant.RETRY
import bridge.view.InputView
import bridge.view.OutputView

class GameController(
    private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView()
) {

    private val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    private val bridgeGame = BridgeGame()
    private var isRestartable = false

    fun start() {
        outputView.printStartMessage()
        outputView.printInputBridgeSizeMessage()
        val bridgeSize = inputView.readBridgeSize()
        playRound(bridgeSize)
    }

    private fun playRound(bridgeSize: Int) {
        var resultPair: Pair<Boolean, List<String>>
        var roundCount = 0
        do {
            isRestartable = false
            val bridgeAnswers = bridgeMaker.makeBridge(bridgeSize)
            resultPair = playTern(bridgeAnswers)
            roundCount += 1
        } while (isRestartable)
        outputView.printResult(resultPair.first, resultPair.second, roundCount)
    }

    private fun playTern(bridgeAnswers: List<String>): Pair<Boolean, List<String>> {
        var resultPair = Pair(true, listOf<String>())
        val moveHistory = listOf<MutableList<String>>(mutableListOf(), mutableListOf()) // 빈 다리 문자열 생성
        for (answer in bridgeAnswers) { // 다리 사이즈만큼 턴 반복
            resultPair = proceedRound(moveHistory, answer)
            if (!resultPair.first) {
                isRestartable = checkRetry()
                break
            }
        }
        return resultPair
    }

    private fun proceedRound(moveHistory: List<MutableList<String>>, answer: String): Pair<Boolean, List<String>> {
        outputView.printChoiceMovingPlace() // 이동 칸 안내 메시지 출력
        val input = inputView.readMoving() // 이동 칸 입력 받기
        val resultString = bridgeGame.move(moveHistory, answer, input) // 입력과 정답을 바탕으로 이동 진행
        outputView.printMap(resultString)
        return Pair((answer == input), resultString)
    }

    private fun checkRetry(): Boolean {
        outputView.printRetry()
        val isRetry = inputView.readGameCommand()
        return (isRetry == RETRY)
    }
}