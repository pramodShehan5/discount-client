package com.pagero.services

import com.pagero.services.discounting.spec.{CalculateDiscountMessage, DiscountingSpec, Item}

import scala.concurrent.Future


object Main extends DiscountingClient {

  import scala.concurrent.ExecutionContext.Implicits.global


  override def init(): Unit = {
    //    BootstrapDatabase.update()
    val discountingClient = createClient(DiscountingSpec)

    Future {
      Thread.sleep(5000)
      val message = CalculateDiscountMessage(List(Item(Option(1), Option("test"), Option(12.40))),Option(1))
      println(s"Sending message")
      discountingClient.sendMessage(message)
    }
  }
}