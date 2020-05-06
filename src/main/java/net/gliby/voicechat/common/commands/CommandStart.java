package net.gliby.voicechat.common.commands;

import net.gliby.voicechat.VoiceChat;
import net.gliby.voicechat.common.api.VoiceChatAPI;
import net.gliby.voicechat.common.networking.ServerNetwork;
import net.gliby.voicechat.common.VoiceChatServer;
import net.gliby.voicechat.common.networking.voiceservers.MinecraftVoiceServer;
import net.gliby.voicechat.common.networking.voiceservers.ServerConnectionHandler;
import net.gliby.voicechat.common.networking.voiceservers.VoiceAuthenticatedServer;
import net.gliby.voicechat.common.networking.voiceservers.VoiceServer;
import net.gliby.voicechat.common.networking.voiceservers.udp.UDPVoiceServer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;
import java.util.List;

public class CommandStart extends CommandBase
{

    @Override
    public String getName() {
        return "vstart";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/vstart : start the server";
    }


    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws WrongUsageException, PlayerNotFoundException
    {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        player.sendMessage(new TextComponentString("Stopping server... "));
        VoiceChat.getServerInstance().Start();
        player.sendMessage(new TextComponentString("Starting server... "));
    }
}