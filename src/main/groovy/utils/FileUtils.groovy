package utils

/**
Groovy extension module helper class
 the first param is used to indicate the base type to extend, in this case File

 */

class FileUtils {

    //
    static File getFileFromResource(final String fileName) throws URISyntaxException{

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

    // this is the extension method for File
    static File getFileFromResource(final File self, final String fileName) throws URISyntaxException{

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
