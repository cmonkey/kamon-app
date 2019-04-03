package org.excavator.kamon.test

import org.excavator.kamon.KamonApp
import org.junit.jupiter.api._
import org.junit.jupiter.api.Assertions._
import org.slf4j.LoggerFactory

class KamonTest{
  val logger = LoggerFactory.getLogger(classOf[KamonTest])

  @Test
  @DisplayName("testKamon")
  @RepeatedTest(10)
  def testKamon() = {
    KamonTest.kamonApp.tracerSegmentByBusiness()
    KamonTest.kamonApp.tracerSegmentByValidator()

    KamonTest.kamonApp.metricsByCounter(1000)
    KamonTest.kamonApp.metricsByHistogram(1000)

    val tracerCurrentToken = KamonTest.kamonApp.tracerCurrentToken()

    logger.info("creating user [token {}]", tracerCurrentToken)

    assertNotNull(tracerCurrentToken)
  }
}

object KamonTest {

  var kamonApp: KamonApp = null

  @BeforeAll
  def initServer() = {
    kamonApp = new KamonApp
    kamonApp.start()
  }

  @AfterAll
  def stopServer() = {
    kamonApp.stop()
  }

}
