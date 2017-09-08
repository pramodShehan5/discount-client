package com.pagero.services

import com.pagero.service.ServiceApplication
import com.pagero.servicecomm.ServiceClient
import com.pagero.services.discountingclient.DiscountingclientServiceInfo

trait DiscountingClient extends ServiceApplication with DiscountingclientServiceInfo {

//  def discountingClient: ServiceClient
}