package hudson.plugins.greenballs;

import hudson.model.UserProperty;
import hudson.model.User;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean(defaultVisibility = 999)
public class EugeneProperty extends UserProperty {

  private boolean enabledEugeneSupport;

  public EugeneProperty() {
    enabledEugeneSupport = false;
  }

  @DataBoundConstructor
  public EugeneProperty(boolean enabledEugeneSupport) {
    this.enabledEugeneSupport = enabledEugeneSupport;
  }

  @Exported
  public User getUser() {
    return user;
  }

  @Exported
  public boolean isEnabledEugeneSupport() {
    return enabledEugeneSupport;
  }

  public void setEnabledEugeneSupport(boolean enabledEugeneSupport) {
    this.enabledEugeneSupport = enabledEugeneSupport;
  }

  @Override
  public String toString() {
    return String.format("EugeneProperty [isEnabledEugeneSupport=%s]", enabledEugeneSupport);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enabledEugeneSupport ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    EugeneProperty other = (EugeneProperty) obj;
    if (enabledEugeneSupport != other.enabledEugeneSupport)
      return false;
    return true;
  }
}
