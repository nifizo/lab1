package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static class Equipment {
        private String name;
        private double weight;
        private double price;

        public Equipment(String name, double weight, double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Equipment{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }

    public static class Sword extends Equipment {
        private int length;

        public Sword(String name, double weight, double price, int length) {
            super(name, weight, price);
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "Sword{" +
                    "name='" + getName() + '\'' +
                    ", weight=" + getWeight() +
                    ", price=" + getPrice() +
                    ", length=" + length +
                    '}';
        }
    }

    public static class Shield extends Equipment {
        private String material;

        public Shield(String name, double weight, double price, String material) {
            super(name, weight, price);
            this.material = material;
        }

        public String getMaterial() {
            return material;
        }

        @Override
        public String toString() {
            return "Shield{" +
                    "name='" + getName() + '\'' +
                    ", weight=" + getWeight() +
                    ", price=" + getPrice() +
                    ", material='" + material + '\'' +
                    '}';
        }
    }

    public static class Knight {
        private List<Equipment> equipmentList;

        public Knight() {
            this.equipmentList = new ArrayList<Equipment>();
        }

        public void equip(Equipment equipment) {
            equipmentList.add(equipment);
        }

        public double calculateTotalCost() {
            double totalCost = 0;
            for (Equipment equipment : equipmentList) {
                totalCost += equipment.getPrice();
            }
            return totalCost;
        }

        public void sortEquipmentByWeight() {
            Collections.sort(equipmentList, new Comparator<Equipment>() {
                @Override
                public int compare(Equipment e1, Equipment e2) {
                    return Double.compare(e1.getWeight(), e2.getWeight());
                }
            });
        }

        public List<Equipment> findEquipmentInPriceRange(double minPrice, double maxPrice) {
            List<Equipment> result = new ArrayList<Equipment>();
            for (Equipment equipment : equipmentList) {
                if (equipment.getPrice() >= minPrice && equipment.getPrice() <= maxPrice) {
                    result.add(equipment);
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return "Knight{" +
                    "equipmentList=" + equipmentList +
                    '}';
        }
    }

    public static void main(String[] args) {
        Knight knight = new Knight();

        Sword sword = new Sword("Excalibur", 5.0, 100.0, 30);
        Shield shield = new Shield("Steel Shield", 8.0, 50.0, "Steel");

        knight.equip(sword);
        knight.equip(shield);

        System.out.println("Total cost of equipment: " + knight.calculateTotalCost());

        knight.sortEquipmentByWeight();
        System.out.println("Sorted equipment by weight: " + knight);

        double minPrice = 40.0;
        double maxPrice = 80.0;
        List<Equipment> equipmentInRange = knight.findEquipmentInPriceRange(minPrice, maxPrice);
        System.out.println("Equipment in price range [" + minPrice + ", " + maxPrice + "]: " + equipmentInRange);
    }
}


