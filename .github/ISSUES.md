# Tracked Issues for Hourly Chime Development

This file tracks the outstanding work items needed to make this project fully functional and ready for production use.

## High Priority - Core Functionality

### Issue 1: Implement User Settings Interface
**Status:** To Do  
**Priority:** High  
**Description:** Create a settings screen that allows users to configure the hourly chime behavior.

**Requirements:**
- [ ] Enable/disable hourly chime
- [ ] Select chime sound from a list of options
- [ ] Choose between sound, vibration, or both
- [ ] Set volume level for chimes
- [ ] Configure quiet hours (start and end time)
- [ ] Save preferences using DataStore or SharedPreferences

**Technical Notes:**
- Use Wear OS Compose components for the UI
- Follow Material Design guidelines for Wear OS
- Implement proper state management
- Add navigation from MainActivity to Settings

**Acceptance Criteria:**
- Settings screen is accessible from main app
- All settings persist across app restarts
- Changes take effect immediately
- UI is optimized for round watch faces

---

### Issue 2: Implement Customizable Chime Sounds
**Status:** To Do  
**Priority:** High  
**Description:** Add multiple chime sound options and allow users to select their preferred sound.

**Requirements:**
- [ ] Include 5-10 different chime sounds in the app
- [ ] Implement sound selection in settings
- [ ] Support custom sound uploads (optional)
- [ ] Preview sounds before selection
- [ ] Optimize sound files for size and battery efficiency

**Technical Notes:**
- Use Android MediaPlayer or SoundPool
- Store sounds in res/raw directory
- Consider using compressed audio formats (OGG)
- Keep each sound file under 100KB

**Acceptance Criteria:**
- Multiple sounds available in settings
- Selected sound plays at the hour
- Sound plays correctly on different devices
- No audio artifacts or quality issues

---

### Issue 3: Do Not Disturb (DND) Integration
**Status:** To Do  
**Priority:** High  
**Description:** Respect system Do Not Disturb settings and implement custom quiet hours.

**Requirements:**
- [ ] Check system DND status before playing chime
- [ ] Silence chimes when DND is active
- [ ] Add custom quiet hours setting independent of system DND
- [ ] Option to override DND for important hours (optional)
- [ ] Visual indicator showing current status (active/muted)

**Technical Notes:**
- Use NotificationManager.getCurrentInterruptionFilter()
- Check DND status in AlarmReceiver before playing sound
- Store quiet hours preferences
- Consider priority mode vs total silence mode

**Acceptance Criteria:**
- Chimes respect system DND settings
- Custom quiet hours work correctly
- No chimes during configured quiet times
- Proper handling of DND mode changes

---

### Issue 4: Flexible Scheduling Options
**Status:** To Do  
**Priority:** Medium  
**Description:** Allow users to customize when hourly chimes should trigger.

**Requirements:**
- [ ] Set start hour (e.g., 8 AM)
- [ ] Set end hour (e.g., 10 PM)
- [ ] Enable/disable for specific days of the week
- [ ] Option for every hour vs every 2/3/4 hours
- [ ] Quick preset schedules (Work Hours, All Day, Evening Only, etc.)

**Technical Notes:**
- Modify AlarmReceiver to check schedule before chiming
- Update alarm scheduling logic in MainActivity
- Use AlarmManager for precise timing
- Consider using WorkManager for more complex scheduling

**Acceptance Criteria:**
- Chimes only trigger during configured hours
- Day-of-week filtering works correctly
- Interval settings are respected
- Schedule persists after device restart

---

## Medium Priority - User Experience

### Issue 5: Improve Main App UI
**Status:** To Do  
**Priority:** Medium  
**Description:** Enhance the main application interface with more useful information and controls.

**Requirements:**
- [ ] Show current status (enabled/disabled)
- [ ] Display next chime time
- [ ] Quick toggle to enable/disable chimes
- [ ] Link to settings
- [ ] Show last chime time with status
- [ ] Add onboarding screens for first-time users

**Technical Notes:**
- Use Wear OS Compose Material components
- Implement proper state management with ViewModel
- Follow Wear OS design patterns (cards, chips, etc.)
- Ensure UI is responsive on different screen sizes

**Acceptance Criteria:**
- UI is intuitive and easy to navigate
- Status information is clear and accurate
- Quick actions work reliably
- Good user experience on round and square displays

---

### Issue 6: Enhance Wear OS Tile
**Status:** To Do  
**Priority:** Medium  
**Description:** Make the Wear OS tile more useful by showing relevant information and quick actions.

**Requirements:**
- [ ] Display next chime time
- [ ] Show enabled/disabled status
- [ ] Add quick toggle to enable/disable
- [ ] Show time until next chime
- [ ] Update tile when settings change

**Technical Notes:**
- Update MainTileService.kt
- Use ProtoLayout for tile UI
- Implement TileUpdateRequester for manual updates
- Handle click actions properly

**Acceptance Criteria:**
- Tile shows accurate, up-to-date information
- Toggle action works reliably
- Tile refreshes when needed
- Visual design is clear and attractive

---

### Issue 7: Improve Complication Functionality
**Status:** To Do  
**Priority:** Low  
**Description:** Make the complication more relevant to the app's purpose.

**Requirements:**
- [ ] Instead of day-of-week, show chime status or countdown
- [ ] Support multiple complication types (SHORT_TEXT, RANGED_VALUE, etc.)
- [ ] Update complication when settings change
- [ ] Show visual indicator (icon/color) for enabled/disabled state

**Technical Notes:**
- Update MainComplicationService.kt
- Implement ComplicationUpdateRequester
- Support LONG_TEXT and RANGED_VALUE types
- Consider showing countdown as progress indicator

**Acceptance Criteria:**
- Complication shows relevant chime information
- Updates reflect current app state
- Works on various watch faces
- Multiple complication types supported

---

## Low Priority - Polish & Optimization

### Issue 8: Battery Optimization
**Status:** To Do  
**Priority:** Medium  
**Description:** Ensure the app has minimal battery impact.

**Requirements:**
- [ ] Use inexact alarms where possible (already implemented)
- [ ] Minimize wake locks
- [ ] Optimize alarm receiver code
- [ ] Profile battery usage on real devices
- [ ] Implement Doze mode compatibility
- [ ] Test with Battery Historian

**Technical Notes:**
- Review alarm scheduling strategy
- Use setInexactRepeating (already in use)
- Minimize work done in AlarmReceiver
- Follow Android battery optimization best practices
- Consider using WorkManager for better battery handling

**Acceptance Criteria:**
- Battery drain is less than 1-2% per day
- App works correctly in Doze mode
- No battery drain complaints in testing
- Passes Android Vitals battery checks

---

### Issue 9: Add Permission Handling and User Education
**Status:** To Do  
**Priority:** Medium  
**Description:** Properly request and explain required permissions.

**Requirements:**
- [ ] Request SCHEDULE_EXACT_ALARM permission on Android 12+
- [ ] Request notification permissions
- [ ] Add rationale explanations for each permission
- [ ] Handle permission denial gracefully
- [ ] Add in-app guidance for granting permissions in Settings

**Technical Notes:**
- Use ActivityResultContracts for permission requests
- Check for special alarm permission (Android 12+)
- Provide clear user-facing explanations
- Test on Android 12, 13, and 14

**Acceptance Criteria:**
- All necessary permissions are requested
- Clear explanations provided to users
- App handles missing permissions gracefully
- Users can easily grant permissions

---

### Issue 10: Implement Notification Channel for Chimes
**Status:** To Do  
**Priority:** Low  
**Description:** If using notifications for chimes, implement proper notification channels.

**Requirements:**
- [ ] Create notification channel for hourly chimes
- [ ] Allow users to control notification behavior
- [ ] Set appropriate importance level
- [ ] Add custom notification sound support
- [ ] Handle notification preferences

**Technical Notes:**
- Use NotificationChannel API (Android O+)
- Set proper channel importance
- Allow customization through system settings
- Consider silent notifications with vibration

**Acceptance Criteria:**
- Notification channel properly configured
- Users can manage notification settings
- Notifications appear correctly
- Sound/vibration preferences respected

---

### Issue 11: Add Unit and Integration Tests
**Status:** To Do  
**Priority:** Medium  
**Description:** Implement comprehensive testing for core functionality.

**Requirements:**
- [ ] Unit tests for alarm scheduling logic
- [ ] Unit tests for settings persistence
- [ ] Integration tests for AlarmReceiver
- [ ] UI tests for settings screens
- [ ] Test coverage > 70%

**Technical Notes:**
- Use JUnit for unit tests
- Use Espresso for UI tests
- Mock AlarmManager for testing
- Test on multiple API levels

**Acceptance Criteria:**
- Core functionality has test coverage
- Tests pass consistently
- CI/CD pipeline includes test execution
- Test documentation is clear

---

### Issue 12: Add Accessibility Support
**Status:** To Do  
**Priority:** Low  
**Description:** Ensure the app is accessible to users with disabilities.

**Requirements:**
- [ ] Add content descriptions to all UI elements
- [ ] Support TalkBack screen reader
- [ ] Test with accessibility scanner
- [ ] Ensure proper focus order
- [ ] Add haptic feedback options

**Technical Notes:**
- Use contentDescription for all images/buttons
- Test with TalkBack enabled
- Follow Android accessibility guidelines
- Use semantic properties in Compose

**Acceptance Criteria:**
- App passes accessibility scanner
- All controls accessible via TalkBack
- Logical navigation order
- Clear audio/haptic feedback

---

### Issue 13: Prepare for Play Store Release
**Status:** To Do  
**Priority:** Low  
**Description:** Complete all requirements for publishing to Google Play Store.

**Requirements:**
- [ ] Create feature graphic and screenshots
- [ ] Write detailed app description
- [ ] Add privacy policy
- [ ] Set up signed release build
- [ ] Test on multiple devices (Pixel Watch, Galaxy Watch, etc.)
- [ ] Prepare promotional materials
- [ ] Set pricing and distribution options

**Technical Notes:**
- Configure release signing in build.gradle
- Use Play Console for listing preparation
- Create at least 3 screenshots per device type
- Review Play Store policies

**Acceptance Criteria:**
- All Play Store assets ready
- App builds in release mode successfully
- Testing complete on multiple devices
- Privacy policy published
- Ready for submission

---

## Documentation & Community

### Issue 14: Create Contributing Guidelines
**Status:** To Do  
**Priority:** Low  
**Description:** Document how others can contribute to the project.

**Requirements:**
- [ ] Create CONTRIBUTING.md
- [ ] Define code style guidelines
- [ ] Set up pull request template
- [ ] Document testing requirements
- [ ] Add code of conduct

**Acceptance Criteria:**
- Clear contribution guidelines published
- PR template in use
- Code style documented

---

## Testing Needed

When implementing features, please test on:
- ✅ Google Pixel Watch (Wear OS 4.0+)
- ⬜ Samsung Galaxy Watch 4/5/6
- ⬜ Fossil Gen 6
- ⬜ TicWatch Pro 3/5
- ⬜ Various screen sizes (small round, large round, square)
- ⬜ Different Android versions (API 30-34)

---

## Notes

- Issues are listed in rough priority order
- Some issues have dependencies on others
- Testing should be done on real devices when possible
- Consider creating GitHub Issues from these items for better tracking
- Welcome community contributions for any of these items

