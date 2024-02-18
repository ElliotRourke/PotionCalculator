package model;

import exception.CannotBuildIngredientException;

import java.util.Objects;

public class Ingredient {

    private static final IngredientBuilder INGREDIENT_BUILDER = new IngredientBuilder();
    private final String name;
    private final Rarity rarity;
    private final int cost;
    private final IngredientType ingredientType;
    private final int aTypeAmount;
    private final int bTypeAmount;
    private final int cTypeAmount;
    private final int dTypeAmount;
    private final int eTypeAmount;
    private final TraitStatus taste;
    private final TraitStatus sensation;
    private final TraitStatus aroma;
    private final TraitStatus visual;
    private final TraitStatus sound;
    private final String location;

    private Ingredient(IngredientBuilder ingredientBuilder) {
        this.name = ingredientBuilder.name;
        this.rarity = ingredientBuilder.rarity;
        this.cost = ingredientBuilder.cost;
        this.ingredientType = ingredientBuilder.ingredientType;
        this.aTypeAmount = ingredientBuilder.aTypeAmount;
        this.bTypeAmount = ingredientBuilder.bTypeAmount;
        this.cTypeAmount = ingredientBuilder.cTypeAmount;
        this.dTypeAmount = ingredientBuilder.dTypeAmount;
        this.eTypeAmount = ingredientBuilder.eTypeAmount;
        this.taste = ingredientBuilder.taste;
        this.sensation = ingredientBuilder.sensation;
        this.aroma = ingredientBuilder.aroma;
        this.visual = ingredientBuilder.visual;
        this.sound = ingredientBuilder.sound;
        this.location = ingredientBuilder.location;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getCost() {
        return cost;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public int getATypeAmount() {
        return aTypeAmount;
    }

    public int getBTypeAmount() {
        return bTypeAmount;
    }

    public int getCTypeAmount() {
        return cTypeAmount;
    }

    public int getDTypeAmount() {
        return dTypeAmount;
    }

    public int getETypeAmount() {
        return eTypeAmount;
    }

    public TraitStatus getTaste() {
        return taste;
    }

    public TraitStatus getSensation() {
        return sensation;
    }

    public TraitStatus getAroma() {
        return aroma;
    }

    public TraitStatus getVisual() {
        return visual;
    }

    public TraitStatus getSound() {
        return sound;
    }

    public String getLocation() {
        return location;
    }

    /*
        Could make more complicated but its not worth time...
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Ingredient) {
            return ((Ingredient) obj).name.equals(this.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public static class IngredientBuilder {
        private String name;
        private Rarity rarity;
        private int cost;
        private IngredientType ingredientType;
        private int aTypeAmount;
        private int bTypeAmount;
        private int cTypeAmount;
        private int dTypeAmount;
        private int eTypeAmount;
        private TraitStatus taste;
        private TraitStatus sensation;
        private TraitStatus aroma;
        private TraitStatus visual;
        private TraitStatus sound;
        private String location;

        public IngredientBuilder() {}

        public Ingredient build() {
            return new Ingredient(this);
        }

        public IngredientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public IngredientBuilder rarity(Rarity rarity) {
            this.rarity = Objects.requireNonNullElse(rarity, Rarity.COMMON);
            return this;
        }

        public IngredientBuilder cost(int cost) {
            if (cost < 0) {
                throw new CannotBuildIngredientException("Invalid cost! Must be greater than 0!");
            }
            this.cost = cost;
            return this;
        }

        public IngredientBuilder ingredientType(IngredientType ingredientType) {
            this.ingredientType = ingredientType;
            return this;
        }

        public IngredientBuilder aTypeAmount(int aTypeAmount) {
            if (aTypeAmount < 0) {
                throw new CannotBuildIngredientException("Invalid aTypeAmount! Must be greater than 0!");
            }
            this.aTypeAmount = aTypeAmount;
            return this;
        }

        public IngredientBuilder bTypeAmount(int bTypeAmount) {
            if (bTypeAmount < 0) {
                throw new CannotBuildIngredientException("Invalid bTypeAmount! Must be greater than 0!");
            }
            this.bTypeAmount = bTypeAmount;
            return this;
        }

        public IngredientBuilder cTypeAmount(int cTypeAmount) {
            if (cTypeAmount < 0) {
                throw new CannotBuildIngredientException("Invalid cTypeAmount! Must be greater than 0!");
            }
            this.cTypeAmount = cTypeAmount;
            return this;
        }

        public IngredientBuilder dTypeAmount(int dTypeAmount) {
            if (dTypeAmount < 0) {
                throw new CannotBuildIngredientException("Invalid dTypeAmount! Must be greater than 0!");
            }
            this.dTypeAmount = dTypeAmount;
            return this;
        }

        public IngredientBuilder eTypeAmount(int eTypeAmount) {
            if (eTypeAmount < 0) {
                throw new CannotBuildIngredientException("Invalid eTypeAmount! Must be greater than 0!");
            }
            this.eTypeAmount = eTypeAmount;
            return this;
        }

        public IngredientBuilder taste(TraitStatus taste) {
            this.taste = Objects.requireNonNullElse(taste, TraitStatus.NEUTRAL);
            return this;
        }

        public IngredientBuilder sensation(TraitStatus sensation) {
            this.sensation = Objects.requireNonNullElse(sensation, TraitStatus.NEUTRAL);
            return this;
        }

        public IngredientBuilder aroma(TraitStatus aroma) {
            this.aroma = Objects.requireNonNullElse(aroma, TraitStatus.NEUTRAL);
            return this;
        }

        public IngredientBuilder visual(TraitStatus visual) {
            this.visual = Objects.requireNonNullElse(visual, TraitStatus.NEUTRAL);
            return this;
        }

        public IngredientBuilder sound(TraitStatus sound) {
            this.sound = Objects.requireNonNullElse(sound, TraitStatus.NEUTRAL);
            return this;
        }

        public IngredientBuilder location(String location) {
            this.location = location;
            return this;
        }
    }
}
