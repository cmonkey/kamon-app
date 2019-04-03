package org.excavator.kamon


import kamon.Kamon
import kamon.trace.Tracer
import org.slf4j.LoggerFactory

class KamonApp {
  val logger = LoggerFactory.getLogger(classOf[KamonApp])

  def start() = {
    Kamon.start()
  }

  def metricsByCounter(incrent: Int) = {
    val someCounter = Kamon.metrics.counter("some-counter")
    someCounter.increment(incrent)
  }

  def metricsByHistogram(record: Int) = {
    val someHistogram =  Kamon.metrics.histogram("some-histogram")
    someHistogram.record(record)
  }

  def stop() = {
    Kamon.shutdown()
  }

  def tracerSegmentByBusiness() = {

    val segment = Kamon.tracer.newContext("context").startSegment("traceSegment", "business-logic", "kamon")

    logger.info(s"segment status = ${segment.status}")

    segment.finish()
  }

  def tracerSegmentByValidator() = {
    val segment = Kamon.tracer.newContext("context").startSegment("tracerSegmentByValidator", "validator-logic", "kamon")

    logger.info(s"segment status = ${segment.status}")

    segment.finish()
  }

  def tracerCurrentToken() = {
    Tracer.currentContext.token
  }

}
