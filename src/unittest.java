import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.company.Main.*;
class unittest {

    @Test
    void testEquip() {
        Knight knight = new Knight();
        Sword sword = new Sword("Excalibur", 5.0, 100.0, 30);

        knight.equip(sword);

        assertEquals(1, knight.calculateTotalCost());
    }

    @Test
    void testSortEquipmentByWeight() {
        Knight knight = new Knight();
        Sword sword1 = new Sword("Excalibur", 5.0, 100.0, 30);
        Sword sword2 = new Sword("Short Sword", 3.0, 50.0, 20);

        knight.equip(sword1);
        knight.equip(sword2);

        knight.sortEquipmentByWeight();

        assertEquals(sword2, knight.findEquipmentInPriceRange(0, 200).get(0));
        assertEquals(sword1, knight.findEquipmentInPriceRange(0, 200).get(1));
    }

    @Test
    void testFindEquipmentInPriceRange() {
        Knight knight = new Knight();
        Sword sword = new Sword("Excalibur", 5.0, 100.0, 30);
        Shield shield = new Shield("Steel Shield", 8.0, 50.0, "Steel");

        knight.equip(sword);
        knight.equip(shield);

        assertEquals(1, knight.findEquipmentInPriceRange(40, 80).size());
        assertEquals(2, knight.findEquipmentInPriceRange(0, 150).size());
        assertEquals(0, knight.findEquipmentInPriceRange(200, 300).size());
    }
}
