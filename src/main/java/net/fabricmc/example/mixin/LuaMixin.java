package net.fabricmc.example.mixin;
import net.minecraft.server.function.CommandFunctionManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CommandFunctionManager.class)
public class LuaMixin {
	//@Inject(at = @At("HEAD"), method = "executeAll(Ljava/util/Collection,Lnet/minecraft/util/Identifier)V")
	//private void executeAll(Collection<CommandFunction> collection, Identifier id,CallbackInfo info) {
	//	
	//}
}
