package net.md_5.bungee.protocol;

import io.netty.buffer.ByteBuf;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@RequiredArgsConstructor
public class PacketWrapper
{

    @Getter public final DefinedPacket packet;
    public final ByteBuf buf;
    @Setter
    private boolean released;

    public void trySingleRelease()
    {
        if ( !released )
        {
            buf.release();
            released = true;
        }
    }
}
