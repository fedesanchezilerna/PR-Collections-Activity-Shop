package shop;

public enum Size {
    XXS(0),
    XS(0),
    S(0),
    M(0),
    L(1.05f),
    XL(1.75f),
    XXL(2.55f);

    private final float extraPrice;

    Size(float extraPrice) {
        this.extraPrice = extraPrice;
    }

    public float getExtraPrice() {
        return extraPrice;
    }
}
