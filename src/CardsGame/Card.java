package CardsGame;


enum Type{
    HEART,DIAMOND,SPADE,CLUB
}
enum Value{
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}
public class Card {
    Type type;
    Value value;

    public Card(Type type, Value value) {
        this.type = type;
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " type-" + type +
                " value-" + value+"," ;
    }
}
