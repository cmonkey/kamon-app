package org.excavator.kamon

import java.util.concurrent.TimeUnit

import kamon.Kamon
import kamon.trace.Tracer

class KamonApp {

  def start() = {
    Kamon.start()
  }

  def stop() = {
    Kamon.shutdown()
  }

  def tracerSegmentByBusiness() = {

    val segment = Tracer.currentContext.startSegment("traceSegment", "business-logic", "kamon")

    TimeUnit.SECONDS.sleep(5)

    segment.finish()
  }

  def tracerSegmentByValidator() = {
    val segment = Tracer.currentContext.startSegment("tracerSegmentByValidator", "validator-logic", "kamon")

    TimeUnit.SECONDS.sleep(5)

    segment.finish()
  }

  def tracerCurrentToken() = {
    Tracer.currentContext.token
  }

}
