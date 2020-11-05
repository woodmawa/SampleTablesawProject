package utils

class FileUtils {

    static File getFileFromResource(String fileName) throws URISyntaxException{

        //get the root classloader from this class
        ClassLoader classLoader = FileUtils.getClassLoader()
        URL resource = classLoader.getResource(fileName)
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName)
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI())
        }

    }

}
