package org.excavator.kamon.test

import org.junit.jupiter.api._
import org.junit.jupiter.api.Assertions._
import org.slf4j.LoggerFactory

class KamonTest{
  val logger = LoggerFactory.getLogger(classOf[KamonTest])

  @Test
  @DisplayName("testKamon")
  @RepeatedTest(10)
  def testKamon() = {
    assertNotNull("")
  }
}

object KamonTest {

  @BeforeAll
  def initServer() = {
  }

}
