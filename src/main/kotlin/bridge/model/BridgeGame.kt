package bridge.model

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {

    fun move(bridgeString: List<MutableList<String>>, answer: String, input: String): List<String> {
        val (upperResult, lowerResult) = BridgeGame().getResult(answer, input) // 입력값 바탕으로 결과 받아오기
        bridgeString.add(upperResult, lowerResult) // 다리 문자열에 추가
        return makeTurnResult(bridgeString) // 다리 문자열 기반으로 결과 생성
    }


    private fun List<MutableList<String>>.add(s1: String, s2: String) {
        this[0].add(s1)
        this[1].add(s2)
    }

    private fun makeTurnResult(bridgeString: List<MutableList<String>>): List<String> {
        return bridgeString.map { it.joinToString(separator = " | ", prefix = "[ ", postfix = " ]") }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun getResult(answer: String, input: String): List<String> {
        val result = when (answer == input) {
            true -> "O"
            false -> "X"
        }
        return when (answer == "U") {
            true -> moveUp(result)
            false -> moveDown(result)
        }
    }

    private fun moveUp(result: String) = listOf("$result", " ")
    private fun moveDown(result: String) = listOf(" ", "$result")


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {}
}
