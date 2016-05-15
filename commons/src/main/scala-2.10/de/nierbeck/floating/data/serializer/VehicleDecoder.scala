package de.nierbeck.floating.data.serializer

import java.io.{ ByteArrayInputStream, ObjectInputStream }

import de.nierbeck.floating.data.domain.Vehicle
import kafka.serializer.Decoder
import kafka.utils.VerifiableProperties

/**
 * Created by anierbeck on 09.05.16.
 */
class VehicleDecoder(props: VerifiableProperties) extends Decoder[Vehicle] {
  override def fromBytes(bytes: Array[Byte]): Vehicle = {
    val ois = new ObjectInputStream(new ByteArrayInputStream(bytes))
    ois.readObject().asInstanceOf[Vehicle]
  }
}