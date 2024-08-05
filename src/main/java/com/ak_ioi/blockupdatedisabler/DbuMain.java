package com.ak_ioi.blockupdatedisabler;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.ak_ioi.blockupdatedisabler.handler.DbuEventHandler;
import org.apache.logging.log4j.Logger;

@Mod(modid = DbuMain.MODID, name = DbuMain.NAME, version = DbuMain.VERSION)
public abstract class NoBlockUpdateMixin {
    @Inject(method = "neighborChanged", at = @At("HEAD"), cancellable = true)
    private void onNeighborChanged(BlockPos pos, IBlockState state, CallbackInfo ci) {
        // Annuler les mises à jour des blocs voisins
        ci.cancel();
    }
}
