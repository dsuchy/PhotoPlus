import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TopicRemoveComponent } from './topic-remove.component';

describe('RemoveComponent', () => {
  let component: TopicRemoveComponent;
  let fixture: ComponentFixture<TopicRemoveComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ TopicRemoveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicRemoveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
