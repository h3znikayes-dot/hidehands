package com.example.hidehands.mixin;

import com.example.hidehands.HideHandsClient;
import net.minecraft.client.renderer.ItemInHandRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public class HideHandsMixin {
	// Only the method name is targeted (no argument list) so this survives signature
	// changes between 26.x snapshots. If the method is renamed, the game fails fast at launch.
	@Inject(method = "renderHandsWithItems", at = @At("HEAD"), cancellable = true)
	private void hidehands$skipHands(CallbackInfo ci) {
		if (HideHandsClient.shouldHideHands()) {
			ci.cancel();
		}
	}
}
