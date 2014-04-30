package hudson.plugins.greenballs;

import hudson.Extension;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import hudson.model.User;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

@Extension
public class EugenePropertyDescriptor extends UserPropertyDescriptor {

  public EugenePropertyDescriptor() {
    super(EugeneProperty.class);
  }

  @Override
  public String getDisplayName() {
    return Messages.EugeneSupport_DisplayName();
  }

  private EugeneProperty newInstanceIfJSONIsNull(StaplerRequest req) throws FormException {
    if (req.getParameter("enabledEugeneSupport") != null) {
      return new EugeneProperty(Boolean.parseBoolean(req.getParameter("enabledEugeneSupport")));
    } else {
      return new EugeneProperty();
    }
  }

  @Override
  public EugeneProperty newInstance(StaplerRequest req, JSONObject formData) throws hudson.model.Descriptor.FormException {
    if (formData == null) {
      return newInstanceIfJSONIsNull(req);
    }
    if (formData.has("enabledEugeneSupport")) {
      return req.bindJSON(EugeneProperty.class, formData);
    }
    return new EugeneProperty();
  }

  @Override
  public UserProperty newInstance(User arg0) {
    return null;
  }
}
