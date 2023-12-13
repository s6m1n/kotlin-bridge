package bridge.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BridgeGameTest {

    @Nested
    @DisplayName("move 메서드 테스트")
    inner class IsApplicableTest {
        @Test
        fun `D를 정답으로 맞췄을 때`() {
            val moveHistory = listOf<MutableList<String>>(mutableListOf(), mutableListOf())
            val result = BridgeGame().move(moveHistory, "D", "D")
            assertEquals(listOf("[   ]", "[ O ]"), result)
        }

        @Test
        fun `U를 정답으로 맞췄을 때`() {
            val moveHistory = listOf<MutableList<String>>(mutableListOf(), mutableListOf())
            val result = BridgeGame().move(moveHistory, "U", "U")
            assertEquals(listOf("[ O ]", "[   ]"), result)
        }

        @Test
        fun `D를 오답으로 맞췄을 때`() {
            val moveHistory = listOf<MutableList<String>>(mutableListOf(), mutableListOf())
            val result = BridgeGame().move(moveHistory, "U", "D")
            assertEquals(listOf("[ X ]", "[   ]"), result)
        }

        @Test
        fun `U를 오답으로 맞췄을 때`() {
            val moveHistory = listOf<MutableList<String>>(mutableListOf(), mutableListOf())
            val result = BridgeGame().move(moveHistory, "D", "U")
            assertEquals(listOf("[   ]", "[ X ]"), result)
        }


        @Test
        fun `moveHistory 값 존재, D를 오답으로 맞췄을 때`() {
            val moveHistory = listOf<MutableList<String>>(mutableListOf("X"), mutableListOf(" "))
            val result = BridgeGame().move(moveHistory, "U", "D")
            assertEquals(listOf("[ X | X ]", "[   |   ]"), result)
        }

        @Test
        fun `moveHistory 값 존재, U를 오답으로 맞췄을 때`() {
            val moveHistory = listOf<MutableList<String>>(mutableListOf("X"), mutableListOf(" "))
            val result = BridgeGame().move(moveHistory, "D", "U")
            assertEquals(listOf("[ X |   ]", "[   | X ]"), result)
        }
    }
}