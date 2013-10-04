public class PrintPrimes {
  int numberOfPrimes;
  int numberOfPrimesPerColumn;
  int numberOfColumnsPerPage;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int numberOfPrimesPerColumn, int numberOfColumnsPerPage, int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.numberOfPrimesPerColumn  = numberOfPrimesPerColumn;
    this.numberOfColumnsPerPage  = numberOfColumnsPerPage;
    this.ORDMAX = ORDMAX;
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
      int N;
      int MULT[] = new int[ORDMAX + 1];

      int integerTested = 1;
      int ithElement = 2;
      int square = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          integerTested = integerTested + 2;
          if (integerTested == square) {
            ithElement = ithElement + 1;
            square = listOfPrimes[ithElement] * listOfPrimes[ithElement];
            MULT[ithElement - 1] = integerTested;
          }
          N = 2;
          JPRIME = true;
          while (N < ithElement && JPRIME) {
            while (MULT[N] < integerTested)
              MULT[N] = MULT[N] + listOfPrimes[N] + listOfPrimes[N];
              if (MULT[N] == integerTested)
                JPRIME = false;
                N = N + 1;
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

					 
