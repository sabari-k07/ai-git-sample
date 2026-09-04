"""A small command-line calculator for basic arithmetic."""


def calculate(first: float, operator: str, second: float) -> float:
    """Return the result of applying operator to two numbers."""
    if operator == "+":
        return first + second
    if operator == "-":
        return first - second
    if operator == "*":
        return first * second
    if operator == "/":
        if second == 0:
            raise ZeroDivisionError("cannot divide by zero")
        return first / second
    raise ValueError(f"unsupported operator: {operator}")


def main() -> None:
    print("Basic Calculator")
    print("Enter q at any prompt to quit.")

    while True:
        first_input = input("First number: ").strip()
        if first_input.lower() == "q":
            break

        operator = input("Operation (+, -, *, /): ").strip()
        if operator.lower() == "q":
            break

        second_input = input("Second number: ").strip()
        if second_input.lower() == "q":
            break

        try:
            result = calculate(float(first_input), operator, float(second_input))
            print(f"Result: {result:g}")
        except ValueError:
            print("Please enter valid numbers and one of +, -, *, or /.")
        except ZeroDivisionError as error:
            print(f"Error: {error}.")


if __name__ == "__main__":
    main()