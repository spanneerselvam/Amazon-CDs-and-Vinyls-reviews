//Overall Outline:
  /*reading text file
  clean the data
  build positive dictionary goodwords<string, double>
  build negative dictionary badwords<string, double>
  compute probabilities based on classification (bad/good) depending on word
  test
  evaluate
  visualization
  */
  //read all folders in movie reviews NOTE: get file name
  public void listFilesForFolder(final File folder) {
      for (final File fileEntry : folder.listFiles()) {
          if (fileEntry.isDirectory()) {
              listFilesForFolder(fileEntry);
          } else {
              System.out.println(fileEntry.getName());
          }
      }
  }
  final File folder = new File("/Documents/GitHub/Amazon-CDs-and-Vinyls-reviews");
  listFilesForFolder(folder);
  File folder = new File("aclImdb_v1.tar.gz");
  File[] listOfFiles = folder.listFiles();
for (int i = 0; i < listOfFiles.length; i++) {
  File file = listOfFiles[i];
  if (file.isFile() && file.getName().endsWith(".txt")) {
    String content = FileUtils.readFileToString(file);
    /* do somthing with content */
  }
}

   // cleans and gets rid of stop words
   private String[] clean(String doc) {
     String[] titles = doc.toLowerCase().replaceAll("[^\\w ]", "").split("\\s+");
     StopWords stop = new StopWords();
     ArrayList<String> holder = new ArrayList<>();
     for (int i = 0; i < titles.length; i++) {
       if (stop.isStopWord(titles[i])) {
         titles[i] = null;
         continue;
       }
     }

     titles = holder.toArray(new String[holder.size()]);
     return titles;
   }
