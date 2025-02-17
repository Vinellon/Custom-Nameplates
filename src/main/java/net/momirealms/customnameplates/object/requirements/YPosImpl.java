/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customnameplates.object.requirements;

import org.bukkit.entity.Player;

import java.util.List;

public record YPosImpl(List<String> yPos) implements Requirement {

    @Override
    public boolean isConditionMet(Player player) {
        int y = (int) player.getLocation().getY();
        for (String range : yPos) {
            String[] yMinMax = range.split("~");
            if (y > Integer.parseInt(yMinMax[0]) && y < Integer.parseInt(yMinMax[1])) {
                return true;
            }
        }
        return false;
    }
}