package bridge.util

object Constant {
    const val UP = "U"
    const val DOWN = "D"
    const val QUIT = "Q"
    const val RETRY = "R"
    const val ANSWER = "O"
    const val WRONG_ANSWER = "X"
    const val SUCCESS = "성공"
    const val FAIL = "실패"
    const val FINAL_RESULT = "\n최종 게임 결과"
    const val IS_SUCCESS = "게임 성공 여부: "
    const val TOTAL_TRIAL = "총 시도한 횟수: "
    const val SEPARATOR = " | "
    const val PREFIX = "[ "
    const val POSTFIX = " ]"
    const val MIN_BRIDGE_SIZE = 3
    const val MAX_BRIDGE_SIZE = 20
    const val INVALID_BRIDGE_SIZE_RANGE = "[ERROR] 3 이상 20 이하의 정수를 입력해주세요"
    const val INVALID_BRIDGE_SIZE_FORMAT = "[ERROR] 입력값이 숫자가 아닙니다"
    const val INVALID_BRIDGE_MOVING_PLACE = "[ERROR] U 또는 D만 입력해주세요"
    const val INVALID_BRIDGE_RETRY_COMMAND = "[ERROR] Q 또는 R만 입력해주세요"
    const val INVALID_VALUE = "[ERROR] 잘못된 값입니다"
    const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
    const val INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요."
    const val INPUT_MOVE_COMMAND_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)"
    const val INPUT_RETRY_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
}