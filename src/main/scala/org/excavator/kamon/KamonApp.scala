package org.excavator.kamon

import kamon.Kamon

class KamonApp {

  def start() = {
    Kamon.start()
  }

  def stop() = {
    Kamon.shutdown()
  }

  def trance() = {
  }
}
