package dogged.grapple.listeners;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class GrappleListener implements Listener {

    @EventHandler
    public void onGrappleUse(PlayerFishEvent e) {
        Player p = e.getPlayer();

        if (p.getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (p.getInventory().getItemInMainHand().getItemMeta().displayName() == null) return;

        TextComponent displayName_tc = (TextComponent) p.getInventory().getItemInMainHand().getItemMeta().displayName();
        String displayName = displayName_tc.content();
        if (!displayName.equals("§c§lGrappling Hook")) return;

        if (e.getState() == PlayerFishEvent.State.IN_GROUND) {
            Location blockLoc = e.getHook().getLocation();
            Location playerLoc = p.getLocation();

            Vector direction = blockLoc.toVector().subtract(playerLoc.toVector());
            direction = direction.normalize();

            Vector velocity = direction.multiply(blockLoc.distance(playerLoc) / 4.5);
            p.setVelocity(velocity);
        }
    }
}
