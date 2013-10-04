public class PrintPrimes {
  int numberOfPrimes;
  int numberOfPrimesPerColumn;
  int numberOfColumnsPerPage;
  int maximumNumberOfElements;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int numberOfPrimesPerColumn, int numberOfColumnsPerPage, int maximumNumberOfElements) {
    this.numberOfPrimes   = numberOfPrimes;
    this.numberOfPrimesPerColumn  = numberOfPrimesPerColumn;
    this.numberOfColumnsPerPage  = numberOfColumnsPerPage;
    this.maximumNumberOfElements = maximumNumberOfElements;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean JPRIME;
      int i;
      int multiples[] = new int[maximumNumberOfElements + 1];

      int integerTested = 1;
      int ithElement = 2;
      int square = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          integerTested = integerTested + 2;
          if (integerTested == square) {
            ithElement = ithElement + 1;
            square = listOfPrimes[ithElement] * listOfPrimes[ithElement];
            multiples[ithElement - 1] = integerTested;
          }
          i = 2;
          JPRIME = true;
          while (i < ithElement && JPRIME) {
            while (multiples[i] < integerTested)
              multiples[i] = multiples[i] + listOfPrimes[i] + listOfPrimes[i];
              if (multiples[i] == integerTested)
                JPRIME = false;
                i = i + 1;
          }
        } while (!JPRIME);
        listOfPrimes[primesFoundSoFar] = integerTested;
      }
    }

    public void printPrimes() {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          for (int rowOffset = pageOffset; rowOffset < pageOffset + numberOfPrimesPerColumn; rowOffset++){
        	for (int numberOfColumns = 0; numberOfColumns < numberOfColumnsPerPage; numberOfColumns++)
        		if (rowOffset + numberOfColumns * numberOfPrimesPerColumn <= numberOfPrimes)
        		System.out.format("%10d", listOfPrimes[rowOffset + numberOfColumns * numberOfPrimesPerColumn]);
                System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + numberOfPrimesPerColumn * numberOfColumnsPerPage;
        }
    }
}

					 
