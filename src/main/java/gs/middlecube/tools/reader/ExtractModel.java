package gs.middlecube.tools.reader;

import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.DefaultProjectBuildingRequest;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingRequest;

import java.io.File;
import java.io.FileReader;

public class ExtractModel {
    static MavenProject buildModel(String fileLocation){
        Model model = null;
        FileReader reader = null;
        MavenXpp3Reader mavenreader = new MavenXpp3Reader();
        try {
            File file = FileReaderUtil.getPOMFile(fileLocation);
            reader = new FileReader(file);
            model = mavenreader.read(reader);
            model.setPomFile(file);
        }catch(Exception e){
            e.printStackTrace();
        }
        MavenProject project = new MavenProject(model);
        return project;
    }

    static MavenProject bundleProject(MavenProject mavenProject){
        ProjectBuildingRequest configuration = new DefaultProjectBuildingRequest();
        configuration.setProcessPlugins( false );
//        TODO : bundle maven project
//        configuration.setRepositorySession( session );
//        org.apache.maven.artifact.Artifact artifact = new org.apache.maven.artifact.DefaultArtifact(groupId, artifactId, version, "compile", "", "", new DefaultArtifactHandler());
//        MavenProject project = projectBuilder.build(artifact, configuration).getProject();
        return null;
    }

//    TODO : DependencyManagement and Scopes pull out

    public static MavenProject getMavenProject(String fileLocation){
        return buildModel(fileLocation);
    }
}
