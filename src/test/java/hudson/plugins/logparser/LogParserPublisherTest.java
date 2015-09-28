package hudson.plugins.logparser;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jenkinsci.plugins.workflow.structs.DescribableHelper;
import org.junit.Test;

import jenkins.tasks.SimpleBuildStep;

public class LogParserPublisherTest {
    
    @Test
    public void testWorkflowInstantiation() throws Exception {
        Map<String, Object> m = getInstanceParameters();
        
        Object inst = (LogParserPublisher) DescribableHelper.instantiate(LogParserPublisher.class.asSubclass(SimpleBuildStep.class), m);
                
        assertThat(inst).isInstanceOf(LogParserPublisher.class);
        
        LogParserPublisher p = (LogParserPublisher) inst;
        assertThat(new Object[]{
                p.failBuildOnError,
                p.unstableOnWarning,
                p.showGraphs,
                p.useProjectRule,
                p.projectRulePath,
                p.parsingRulesPath
        }).isEqualTo(new Object[]{true, true, true, true, "temp.rules", null});
    }
    
    /**
     * This prepares parameters the same way as in the {@link LogParserTestCase} using
     * step([$class: 'LogParserPublisher', failBuildOnError: true, unstableOnWarning: true, showGraphs: true, projectRulePath: 'temp.rules'])"
     * @return
     */
    private Map<String, Object> getInstanceParameters() {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        m.put("failBuildOnError", true);
        m.put("unstableOnWarning", true);
        m.put("showGraphs", true);
        m.put("projectRulePath", "temp.rules");
        
        return m;
    }
    
}
