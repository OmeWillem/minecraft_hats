package dev.jensderuiter.minecrafthats.hat;

import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class HatComponent {

    protected final Display display;
    protected final Player player;
    protected Vector offset;

    public HatComponent(Display display, Player player, Vector offset) {
        this.display = display;
        this.player = player;
        this.offset = offset;
    }

    public void destroy() {
        this.display.remove();
    }

    /**
     * Rotate the component around the neck location with the given yaw and pitch values.
     * @param yaw the player head's yaw
     * @param pitch the player head's pitch
     */
    public void tick(double yaw, double pitch) {
        Vector newOffset = this.offset.clone();
        newOffset = this.rotateAroundAxisX(newOffset, pitch);

        yaw = Math.toRadians(yaw);
        double sinus = Math.sin(yaw);
        double cosinus = Math.cos(yaw);
        double newX = newOffset.getX() * cosinus - newOffset.getZ() * sinus;
        double newZ = newOffset.getZ() * cosinus + newOffset.getX() * sinus;

        newOffset.setX(newX);
        newOffset.setZ(newZ);

        this.display.teleport(this.getNeckLocation().add(newOffset));
    }

    private Vector rotateAroundAxisX(Vector v, double angle) {
        angle = Math.toRadians(angle);
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }

    /**
     * Get the player's neck location.
     * This should be the point to rotate around.
     * @return the player's neck location
     */
    public Location getNeckLocation() {
        return this.player.getEyeLocation().clone().subtract(0, 0.2, 0);
    }

}
