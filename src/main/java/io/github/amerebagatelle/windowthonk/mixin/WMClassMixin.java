package io.github.amerebagatelle.windowthonk.mixin;

import io.github.amerebagatelle.windowthonk.Settings;
import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.WindowSettings;
import net.minecraft.client.util.MonitorTracker;
import net.minecraft.client.util.Window;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class WMClassMixin {
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwCreateWindow(IILjava/lang/CharSequence;JJ)J"))
    public void setWMClass(WindowEventHandler eventHandler, MonitorTracker monitorTracker, WindowSettings settings, @Nullable String videoMode, String title, CallbackInfo ci) {
        if (Settings.INSTANCE.changeWMClass) {
            GLFW.glfwWindowHintString(GLFW.GLFW_X11_CLASS_NAME, "Minecraft");
            GLFW.glfwWindowHintString(GLFW.GLFW_X11_INSTANCE_NAME, "Minecraft");
        }
    }
}
