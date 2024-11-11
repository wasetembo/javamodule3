import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    // Default constructor for Rational 0
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Constructor with specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd).multiply(denominator.signum() < 0 ? BigInteger.valueOf(-1) : BigInteger.ONE);
        this.denominator = denominator.abs().divide(gcd);
    }

    // Constructor with long values for convenience
    public Rational(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    // Add method
    public Rational add(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).add(this.denominator.multiply(other.numerator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Subtract method
    public Rational subtract(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).subtract(this.denominator.multiply(other.numerator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Multiply method
    public Rational multiply(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Divide method
    public Rational divide(Rational other) {
        if (other.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        BigInteger newNumerator = this.numerator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }

    // Getters for numerator and denominator
    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    // Override toString method for a formatted output
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    // Override compareTo method
    @Override
    public int compareTo(Rational other) {
        BigInteger left = this.numerator.multiply(other.denominator);
        BigInteger right = this.denominator.multiply(other.numerator);
        return left.compareTo(right);
    }

    // Override doubleValue for numeric operations
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // Override abstract methods from Number
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }
}
