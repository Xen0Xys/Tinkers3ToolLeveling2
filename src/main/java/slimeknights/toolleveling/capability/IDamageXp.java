package slimeknights.toolleveling.capability;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;

public interface IDamageXp extends INBTSerializable<NBTTagList> {

  void addDamageFromTool(float damage, ItemStack tool, Player player);

  float getDamageDealtByTool(ItemStack tool, Player player);

  void distributeXpToTools(LivingEntity deadEntity);
}
