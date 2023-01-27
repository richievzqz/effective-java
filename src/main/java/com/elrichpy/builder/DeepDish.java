package com.elrichpy.builder;

public class DeepDish extends Pizza{
    private final String filling;
    public static class Builder extends Pizza.Builder<Builder>{
        private String filling;

        public Builder filling(String filling) {
            this.filling = filling;
            return this;
        }

        @Override
        public DeepDish build() {
            return new DeepDish(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
    private DeepDish(Builder builder) {
        super(builder);
        filling = builder.filling;
    }
}
