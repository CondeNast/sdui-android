package dev.helw.playground.sdui.serializer

import dev.helw.playground.sdui.design.core.IconToken
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class IconTokenSerializer : KSerializer<IconToken> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("IconToken", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: IconToken) {
        encoder.encodeString(value.name.lowercase())
    }

    override fun deserialize(decoder: Decoder): IconToken {
        val tokenString = decoder.decodeString().lowercase()
        return IconToken.values()
            .find { it.name.lowercase() == tokenString } ?: IconToken.FAVORITE
    }
}