package gs.middlecube.tools.reader;

import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExtractModelTest {

    @Test
    void getMavenProject(){
        String fileLocation = "src/test/resources/pom.xml";

        File file = new File(fileLocation);
        assertTrue(file.isFile());

        MavenProject mavenProject = ExtractModel.getMavenProject(fileLocation);
        assertNotNull(mavenProject);

        System.out.println(mavenProject.getArtifact());
        mavenProject.getModel().getDependencies().forEach(dependency ->  {
            System.out.println(dependency.getGroupId() + " : " + dependency.getArtifactId() + " : " + dependency.getVersion());
        });
    }
}