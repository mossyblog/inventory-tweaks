import java.util.logging.Logger;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

/**
 * @author Jimeo Wan (jimeo.wan at gmail.com)
 * Website: {@link http://wan.ka.free.fr/?invtweaks}
 * Source code: {@link https://github.com/jimeowan/minecraft-mod-inventory-tweaks}
 * 
 */
public class mod_InvTweaks extends BaseMod {

    @SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger("mod_InvTweaks");
    
	private InvTweaks instance;
    
    public mod_InvTweaks() {
    	
    	// Register key
    	Minecraft mc = ModLoader.getMinecraftInstance();
    	qb sortKey = new qb("Sort inventory", Keyboard.KEY_R);
    	ModLoader.RegisterKey(this, sortKey, true);
    	
    	// Register OnTickInGame event
    	ModLoader.SetInGameHook(this, true, true);

    	// Instantiate mod core
    	instance = new InvTweaks(mc);
    }
    
	@Override
	public String Version() {
		return "1.05 (1.6.6)";
	}
    
	/**
	 * Sort inventory
	 */
    public final void KeyboardEvent(qb keybinding)
    {
    	instance.onSortingKeyPressed();
    }
    
    public boolean OnTickInGame(Minecraft minecraft)
    {
    	instance.onTick();
    	return true; // TODO: What's this for? 
    }
    
}