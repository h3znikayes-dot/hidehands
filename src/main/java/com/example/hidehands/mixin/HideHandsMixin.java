package com.example.hidehands.mixin;

import com.example.hidehands.HideHandsClient;
import net.minecraft.client.renderer.FirstPersonHandsAndItemsRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FirstPersonHandsAndItemsRenderer.class)
public class HideHandsMixin {
	@Inject(method = {"submitHandsWithItems", "renderHandsWithItems"}, at = @At("HEAD"), cancellable = true, require = 1)
	private void hidehands$skipHands(CallbackInfo ci) {
		if (HideHandsClient.shouldHideHands()) {
			ci.cancel();
		}
	}
}
