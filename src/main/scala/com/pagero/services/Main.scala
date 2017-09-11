package com.pagero.services

import com.pagero.services.discounting.spec.{CalculateDiscountMessage, CalculateDiscountReply, DiscountingSpec, Item}

import scala.concurrent.Future


object Main extends DiscountingClient {

  import scala.concurrent.ExecutionContext.Implicits.global


  override def init(): Unit = {
    //    BootstrapDatabase.update()
    val discountingClient = createClient(DiscountingSpec)

    Future {
      Thread.sleep(5000)
      val message = CalculateDiscountMessage(List(Item(Option(1), Option("test"), Option(45000)), Item(Option(1), Option("test"), Option(30000))), Option(1))
      println(s"Sending message")
      discountingClient.sendMessage(message)

    }

    discountingClient addReplyHandler {
      implicit ctx => {
        case reply: CalculateDiscountReply =>
          Future {
            println(s"reply = $reply")
          }
      }
    }
  }
}