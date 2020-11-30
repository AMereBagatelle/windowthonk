package io.github.amerebagatelle.windowthonk.mixin;

import io.github.amerebagatelle.windowthonk.Settings;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class WindowTitleMixin {
    @Inject(method = "getWindowTitle", at = @At("TAIL"), cancellable = true)
    public void getWindowTitle(CallbackInfoReturnable<String> cir) {
        if (Settings.INSTANCE.changeWindowTitle) {
            // add the star just to keep some kind of consistency with vanilla
            cir.setReturnValue("Minecraft*");
            cir.cancel();
        }
    }
}
