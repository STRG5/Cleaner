package home;

public enum OutputState {
  SUCCESS("#2f7a4a"),
  ERROR("#b12b2b"),
  WARNING("#407fe5");

  private String color;

  OutputState(String color) {
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }
}
