package io.github.amerebagatelle.windowthonk.mixin;

import io.github.amerebagatelle.windowthonk.Settings;
import net.minecraft.client.util.Monitor;
import net.minecraft.client.util.MonitorTracker;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Window.class)
public class CorrectMonitorMixin {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/MonitorTracker;getMonitor(J)Lnet/minecraft/client/util/Monitor;"))
    public Monitor getCorrectMonitor(MonitorTracker monitorTracker, long l) {
        return Settings.INSTANCE.openOnHoveredMonitor ? null : monitorTracker.getMonitor(l);
    }
}
