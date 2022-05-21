package slimeknights.toolleveling;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import slimeknights.tconstruct.common.Sounds;

import java.awt.*;

@Mod.EventBusSubscriber(modid = TinkerToolLeveling.MODID)
public class CommonProxy {

  private static SoundEvent SOUND_LEVELUP = sound("levelup");

  public void playLevelupDing(Player player) {
    Sounds.PlaySoundForPlayer(player, SOUND_LEVELUP, 1f, 1f);
  }

  public void sendLevelUpMessage(int level, ItemStack itemStack, Player player) {
    TextComponent textComponent;
    // special message
    if(I18n.canTranslate("message.levelup." + level)) {
      textComponent = new TextComponentString(TextFormatting.DARK_AQUA + I18n.translateToLocalFormatted("message.levelup." + level, itemStack.getDisplayName() + TextFormatting.DARK_AQUA));
    }
    // generic message
    else {
      textComponent = new TextComponentString(TextFormatting.DARK_AQUA + I18n.translateToLocalFormatted("message.levelup.generic", itemStack.getDisplayName() + TextFormatting.DARK_AQUA, Tooltips.getLevelString(level)));
    }
    player.sendStatusMessage(textComponent, false);
  }

  private static SoundEvent sound(String name) {
    ResourceLocation location = new ResourceLocation(TinkerToolLeveling.MODID, name);
    SoundEvent event = new SoundEvent(location);
    event.setRegistryName(location);
    return event;
  }

  @SubscribeEvent
  public static void registerSoundEvent(RegistryEvent.Register<SoundEvent> event) {
    event.getRegistry().register(SOUND_LEVELUP);
  }
}
